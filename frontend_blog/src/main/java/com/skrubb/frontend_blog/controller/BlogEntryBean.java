/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.frontend_blog.controller;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.skrubb.frontend_blog.blog.BlogEntry;
import com.skrubb.frontend_blog.ejb.BlogEntryEJB;

@Named(value = "blogEntryBean")
@RequestScoped
public class BlogEntryBean {
        @Inject
        private BlogEntryEJB    blogEntryEJB;

        private BlogEntry               blogEntry       = new BlogEntry();

        /**
         * @return the blogEntries
         */
        public List<BlogEntry> getBlogEntries() {
                return blogEntryEJB.findBlogEntries();
        }

        /**
         * @return the blogEntry
         */
        public BlogEntry getBlogEntry() {
                return blogEntry;
        }

        /**
         * @param blogEntry
         *            the blogEntry to set
         */
        public void setBlogEntry(BlogEntry blogEntry) {
                this.blogEntry = blogEntry;
        }

        public String saveBlogEntry() {
                blogEntryEJB.saveBlogEntry(blogEntry);
                return "success";
        }

        public void delete(BlogEntry blogEntry) {
                blogEntryEJB.deleteBlogEntry(blogEntry);
        }
}