/*******************************************************************************
 * Copyright (c) 2000-2014 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *******************************************************************************/
package com.liferay.ide.adt.core.model;

import com.liferay.ide.adt.core.model.internal.JavaProjectConversionService;
import com.liferay.ide.adt.core.model.internal.StatusDerivedValueService;
import com.liferay.ide.adt.core.model.internal.SummaryDerivedValueService;

import org.eclipse.sapphire.ElementHandle;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementProperty;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ExecutableElement;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.java.JavaPackageName;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Derived;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.ReadOnly;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.SensitiveData;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;


/**
 * @author Gregory Amerson
 */
@Service( impl = JavaProjectConversionService.class )
public interface MobileSDKLibrariesOp extends ExecutableElement
{

    ElementType TYPE = new ElementType( MobileSDKLibrariesOp.class );

    // *** ProjectName ***

    ValueProperty PROP_PROJECT_NAME = new ValueProperty( TYPE, "ProjectName" );

    Value<String> getProjectName();
    void setProjectName( String value );


    // *** Url ***

    @Label( standard = "url" )
    @Required
    @DefaultValue( text = "http://localhost:8080/" )
    ValueProperty PROP_URL = new ValueProperty( TYPE, "Url" );

    Value<String> getUrl();
    void setUrl( String value );


    // *** OmniUsername ***

    @Required
    @DefaultValue( text = "test@liferay.com")
    ValueProperty PROP_OMNI_USERNAME = new ValueProperty( TYPE, "OmniUsername" );

    Value<String> getOmniUsername();
    void setOmniUsername( String value );


    // *** OmniPassword ***

    @SensitiveData
    @Required
    @DefaultValue( text = "test" )
    ValueProperty PROP_OMNI_PASSWORD = new ValueProperty( TYPE, "OmniPassword" );

    Value<String> getOmniPassword();
    void setOmniPassword( String value );


    // *** Summary ***

    @Label( standard = "summary" )
    @Derived
    @ReadOnly
    @Service( impl = SummaryDerivedValueService.class )
    ValueProperty PROP_SUMMARY = new ValueProperty( TYPE, "Summary" );

    Value<String> getSummary();
    void setSummary( String value );


    // *** Status ***

    @Label( standard = "status" )
    @Derived
    @Service( impl = StatusDerivedValueService.class )
    ValueProperty PROP_STATUS = new ValueProperty( TYPE, "Status" );

    Value<String> getStatus();
    void setStatus( String value );

    // *** PreviousServerInstances ***

    @Type( base = ServerInstance.class )
    @ReadOnly
    ListProperty PROP_PREVIOUS_SERVER_INSTANCES = new ListProperty( TYPE, "PreviousServerInstances" );

    ElementList<ServerInstance> getPreviousServerInstances();


    // *** SelectedServerInstance ***

    @Type( base = ServerInstance.class )
    @Label( standard = "label" )
    ElementProperty PROP_SELECTED_SERVER_INSTANCE = new ElementProperty( TYPE, "SelectedServerInstance" );

    ElementHandle<ServerInstance> getSelectedServerInstance();


    // *** Package ***

    @Type( base = JavaPackageName.class )
    ValueProperty PROP_PACKAGE = new ValueProperty( TYPE, "Package" );

    Value<JavaPackageName> getPackage();
    void setPackage( String value );
    void setPackage( JavaPackageName value );


    // *** AddSampleCode ***

    @Type( base = Boolean.class )
    @Label( standard = "add sample code for CRUD on Liferay Contacts" )
    ValueProperty PROP_ADD_SAMPLE_CODE = new ValueProperty( TYPE, "AddSampleCode" );

    Value<Boolean> getAddSampleCode();
    void setAddSampleCode( String value );
    void setAddSampleCode( Boolean value );


}