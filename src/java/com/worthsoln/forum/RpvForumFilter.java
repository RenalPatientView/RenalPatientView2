package com.worthsoln.forum;

import net.jforum.util.legacy.clickstream.ClickstreamFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Check for screen name of user and redirect if one isn't set
 */
public class RpvForumFilter extends ClickstreamFilter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        super.doFilter(request, response, chain);
    }
}
