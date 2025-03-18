package com.enjoy.spring.httpcache;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("book")
public class BookController {
    private static final List<String> cache = new ArrayList<>();


    /**
     * 1. 客户端第一次发起HTTP请求时，服务器会返回一个Etag(HTTP Header)
     * <p>
     * 2. 客户端第二次发起同一个请求时，客户端会同时发送一个If-None-Match，而它的值就是Etag的值（此处由发起请求的客户端来设置）
     * <p>
     * 3. 服务器会比对这个客服端发送过来的Etag是否与服务器的相同，如果相同，就将If-None-Match的值设为false，返回状态为304，客户端继续使用本地缓存，不解析服务器返回的数据（这种场景服务器也不返回数据，因为服务器的数据没有变化嘛）
     * <p>
     * 4. Last-Modified（由服务端发送给客户端） 与 If-Modified-Since（由客户端发送服务端） 也是相识的逻辑
     *
     * @see <a href="https://www.cnblogs.com/softidea/p/5986339.html">ETag & If-None-Match</a>
     * @see <a href="https://springdoc.cn/spring/web.html#mvc-caching">Spring MVC caching</a>
     */
    @GetMapping("{id}")
    public ResponseEntity<Map<String, String>> getBook(@PathVariable("id") Long id,
                                                       @RequestHeader(value = "If-None-Match", required = false) String ifNoneMatch
    ) {
        if (null != ifNoneMatch)
            ifNoneMatch = ifNoneMatch.replace("\"", "");

        if (cache.contains(ifNoneMatch)) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).cacheControl(CacheControl.noStore()).build();
        }

        if (id == 1L) {
            cache.add(id.toString());
            return ResponseEntity
                    .ok()
                    // Cache-Control 决定资源在缓存中的存储时间。使用 max-age 参数可以指定资源可以缓存多长时间。
                    // Cache-Control 的常用指令:
                    // max-age=<seconds>: 指定资源在缓存中可保留的时间（以秒为单位）。
                    // no-cache: 强制要求客户端发送请求以验证资源的状态。
                    // no-store: 完全不允许缓存，资源每次请求都从服务器获取。
                    // must-revalidate: 一旦资源过期，必须重新验证。
                    // public: 资源可以被任何缓存（包括中间代理）缓存。
                    // private: 资源仅能被用户的浏览器缓存，不允许中间代理缓存。
                    .cacheControl(CacheControl.maxAge(3, TimeUnit.MINUTES).cachePrivate())
                    // ETag 和 If-None-Match：服务器通过 ETag 标识资源的唯一版本，如果资源未修改，客户端的 If-None-Match 会与当前的 ETag 匹配，服务器返回304。
                    .eTag(id.toString())
                    .body(
                            new HashMap<String, String>() {{
                                put("name", "book1");
                                put("price", "30");
                            }}
                    );
        }

        return ResponseEntity
                .ok()
                .body(
                        new HashMap<String, String>() {{
                            put("name", "book2");
                            put("price", "34");
                        }}
                );
    }
}
