package com.example.hcsweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.hcsweb.service.TenantService;

@Controller
public class TenantController {
	@Autowired TenantService tenantService;
	
}