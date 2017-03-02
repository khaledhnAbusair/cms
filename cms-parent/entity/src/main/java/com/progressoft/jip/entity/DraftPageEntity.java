package com.progressoft.jip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.progressoft.jip.entity.view.DraftPageView;

@Entity
@Table(name = "draft")
public class DraftPageEntity implements DraftPageView {

	@Id
	@Column(name = "draft_id")
	private String pageUrl;

	@Column(name = "draft_title", nullable = false)
	private String pageTitle;

	@Lob
	@Column(name = "draft_content")
	private String pageContent;

	@Lob
	@Column(name = "draft_senullo", nullable = false)
	private String seo;

	@OneToOne
	@JoinColumn(name = "published_page")
	private PageEntity publishedPage;

	@ManyToOne
	@JoinColumn(name = "site_id")
	private SiteEntity siteId;

	@Column(name = "is_landingPage")
	private Boolean isLandingPage = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getPageUrl()
	 */
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getPageTitle()
	 */
	@Override
	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getDraftUrl()
	 */
 

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getPageContent()
	 */
	@Override
	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getSeo()
	 */
	@Override
	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getPublishedPage()
	 */
	@Override
	public PageEntity getPublishedPage() {
		return publishedPage;
	}

	public void setPublishedPage(PageEntity publishedPage) {
		this.publishedPage = publishedPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getSiteId()
	 */
	@Override
	public SiteEntity getSiteId() {
		return siteId;
	}

	public void setSiteId(SiteEntity siteId) {
		this.siteId = siteId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.jip.entity.DraftPageView#getIsLandingPage()
	 */
	@Override
	public Boolean getIsLandingPage() {
		return isLandingPage;
	}

	public void setIsLandingPage(Boolean isLandingPage) {
		this.isLandingPage = isLandingPage;
	}

}
