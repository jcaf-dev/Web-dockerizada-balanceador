package es.rel.dad.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerCache {
	
	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping(value="/cache", method=RequestMethod.GET)
	public String getCacheProveedores(Model model){
		System.out.println("Estoy en items cache");
		ConcurrentMapCacheManager cacheMan=(ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache=(ConcurrentMapCache) cacheMan.getCache("itemsCache");
		model.addAttribute("cache", cache.getNativeCache().toString());
		return "cache";
	}

}
