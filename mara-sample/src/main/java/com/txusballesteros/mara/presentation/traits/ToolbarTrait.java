/*
 * Copyright Txus Ballesteros 2015 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package com.txusballesteros.mara.presentation.traits;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.txusballesteros.mara.R;
import com.txusballesteros.mara.Trait;

@Trait
public class ToolbarTrait implements Initializable {
    private Context context;
    private Toolbar toolbar;

    public ToolbarTrait(Context context) {
        this.context = context;
    }

    @Override
    public void initialize() {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity rootActivity = (AppCompatActivity)context;

            final ViewGroup holderView = (ViewGroup)rootActivity.findViewById(R.id.toolbar_place_holder);
            toolbar = (Toolbar)LayoutInflater
                                    .from(context).inflate(R.layout.trait_toolbar, holderView, false);
            holderView.addView(toolbar);
            rootActivity.setSupportActionBar(toolbar);
        }
    }

    public void enableHomeAsUp() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private ActionBar getActionBar() {
        if (context instanceof AppCompatActivity) {
            return ((AppCompatActivity)context).getSupportActionBar();
        } else {
            return null;
        }
    }
}
