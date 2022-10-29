package com.works.restcontrollers;

import com.works.entities.Address;
import com.works.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressRestController {

    final AddressService aService;
    final CacheManager manager;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Address address) {
        manager.getCache("list").clear();
        return aService.add(address);
    }

    @Cacheable("list")
    @GetMapping("/list/{page}")
    public ResponseEntity list(@PathVariable int page) {
        return aService.list(page);
    }

    @GetMapping("/search")
    public ResponseEntity search( @RequestParam(defaultValue = "") String q,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "city_asc") String sorting ) {
        return aService.search(q, page, sorting);
    }

    @GetMapping("/querySearch")
    public ResponseEntity querySearch( @RequestParam String name, @RequestParam Long cid ) {
        return aService.querySearch(name, cid);
    }

    @GetMapping("/viewCall")
    public ResponseEntity viewCall( ) {
        return aService.viewCall();
    }

}
