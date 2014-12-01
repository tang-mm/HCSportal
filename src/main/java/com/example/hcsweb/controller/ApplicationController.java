package com.example.hcsweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationController {

	@RequestMapping(value = "ccdmApp", method = RequestMethod.GET)
	public RedirectView redirectToCCDM(HttpServletRequest request) {
		// TODO add dynamic url; get SSO user info from request
		String url = "https://172.31.14.195/Portal";
		return new RedirectView(url);
	}

	@RequestMapping(value = "cucdmApp", method = RequestMethod.GET)
	public RedirectView redirectToCUCDM(HttpServletRequest request) {
		// TODO add dynamic url
		String url = "#";
		return new RedirectView(url);
	}

	@RequestMapping(value = "pcaApp", method = RequestMethod.GET)
	public RedirectView redirectToPCA(HttpServletRequest request) {
		// TODO add dynamic url
		String url = "https://172.31.14.200/emsam/index.html";
		return new RedirectView(url);
	}

	@RequestMapping(value = "cuicApp", method = RequestMethod.GET)
	public RedirectView redirectToCUIC(HttpServletRequest request) {
		// TODO add dynamic url
		String url = "https://172.31.14.71:8444/cuic/Login.htmx";
		return new RedirectView(url);
	}

	@RequestMapping(value = "mediaSenseApp", method = RequestMethod.GET)
	public RedirectView redirectToMediaSense(HttpServletRequest request) {
		// TODO add dynamic url + open in an iFrame
		String url = "https://172.31.16.172:8440/mediasense";
		return new RedirectView(url);
	}

	@RequestMapping(value = "scriptEditorApp", method = RequestMethod.GET)
	public RedirectView redirectToScriptEditor(HttpServletRequest request) {
		// TODO add dynamic url
		String url = "#";
		return new RedirectView(url);
	}

}
