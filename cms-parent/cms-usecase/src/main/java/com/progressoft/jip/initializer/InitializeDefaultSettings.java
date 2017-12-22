package com.progressoft.jip.initializer;

import java.util.Objects;

import com.progressoft.jip.entity.PageEntity;
import com.progressoft.jip.entity.SiteEntity;
import com.progressoft.jip.entity.UserEntity;
import com.progressoft.jip.repository.SiteRepository;
import com.progressoft.jip.repository.UserRepository;

public class InitializeDefaultSettings {

	private static final String WELCOME_PAGE_CONTENT = "The Page Content particle itself doesn't have any specific particle settings. It's simply a portal by which any content you have assigned to that page (or type of page) is displayed. You can still, of course, use the Block settings tab to refine the look and presentation of the content block as you would any other particle.";
	private static final String ADMINISTRATOR_MANAGER = "Administrator manager";
	private static final String WELCOME_PAGE_TITLE = "Welcome Page";
	private static final String WELCOME_PAGE_SEO = "welcome seo";
	private static final String WELCOME_PAGE_URL = "/Welcome";
	private static final String ROOT_SITE_NAME = "Root Site";
	private static final String COMLIX_PSSWORD = "P@ssw0rd";
	private static final String ROOT_SITE_URL = "/Root";
	private static final String ADMIN = "admin";

	private SiteRepository siteRepository;
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setSiteRepository(SiteRepository siteRepository) {
		this.siteRepository = siteRepository;
	}

	public void initializeCmsSettings() {
		addAdminUser();
		addRootSite();
	}

	public SiteEntity addRootSite() {
		SiteEntity siteEntity = siteRepository.findBySiteUrl(ROOT_SITE_URL);
		if (Objects.nonNull(siteEntity)) {
			return new SiteEntity();
		}
		siteEntity = new SiteEntity();
		siteEntity.setSiteName(ROOT_SITE_NAME);
		siteEntity.setSiteUrl(ROOT_SITE_URL);
		PageEntity addWelcomePage = addWelcomePage();
		addWelcomePage.setSiteId(siteEntity);
		siteEntity.setLandingPage(addWelcomePage);
		return siteRepository.save(siteEntity);

	}

	public PageEntity addWelcomePage() {

		PageEntity pageEntity = new PageEntity();
		pageEntity.setHtml(true);
		pageEntity.setPublish(false);
		pageEntity.setLandingPage(true);
		pageEntity.setPageContent(WELCOME_PAGE_CONTENT);
		pageEntity.setPageTitle(WELCOME_PAGE_TITLE);
		pageEntity.setPageUrl(WELCOME_PAGE_URL + ROOT_SITE_NAME);
		pageEntity.setSeo(WELCOME_PAGE_SEO);
		return pageEntity;

	}

	public void addAdminUser() {
		UserEntity userEntity = userRepository.findByUserName(ADMIN);
		if (Objects.isNull(userEntity)) {
			userEntity = new UserEntity();
		}
		userEntity.setFullName(ADMINISTRATOR_MANAGER);
		userEntity.setUserName(ADMIN);
		userEntity.setPassword(COMLIX_PSSWORD);
		userRepository.save(userEntity);
	}
}
