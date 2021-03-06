package com.morevaadin.vaadin7.springsecurity.util;

/*
 * #%L
 * Vaadin 7 Spring Security Integration
 * %%
 * Copyright (C) 2012 Nicolas Frankel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.morevaadin.vaadin7.springsecurity.ui.LoginView;
import com.vaadin.navigator.ViewChangeListener;

@SuppressWarnings("serial")
public class ViewChangeSecurityChecker implements ViewChangeListener {

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		if (event.getNewView() instanceof LoginView) {

			return true;
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication == null ? false : authentication.isAuthenticated();
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) {

	}
}
