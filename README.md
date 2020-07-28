# MetaWeatherAPITests

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

MetaWeatherAPITests is a java based project written to test Meta Weather API available at  https://www.metaweather.com/api

It utlises Rest Assured Java library used to test RESTful Web Services (http://rest-assured.io/).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

* JAVA (JDK/JRE)
* IDE (Eclipse, IntelliJ)
* Maven
* TestNG

### Installing

Navigate to https://github.com/KhanZee/MetaWeatherAPITests

Download the code as a ZIP file or using your local Git client

Open/Import project in your chosen IDE

## Dependencies

The following dependencies are mentioned in pom.xml file

	<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>rest-assured</artifactId>
		<version>4.3.1</version>
		<scope>test</scope>
	</dependency>

	<dependency>
		<groupId>org.testng</groupId>
		<artifactId>testng</artifactId>
		<version>7.1.0</version>
		<scope>test</scope>
	</dependency>

	<dependency>
		<groupId>io.rest-assured</groupId>
		<artifactId>json-schema-validator</artifactId>
		<version>4.0.0</version>
	</dependency> 

All required jar files will atuomatically be downloaded by Maven.

## Running the tests

The following classes under src/test/java contain automated tests 

* Location.java - This class contains tests for Location method of Meta Weather API
* LocationDay.java - This class contains tests for "Location Day" method of Meta Weather API
* LocationSearch.Java - This class contains tests for "Location Search" method of Meta Weather API

To run these tests, right click on package com.khanzee.testpackage > Run As > TestNG Test (This step may differ if you are using an IDE other than Eclipse).

This will run all 13 tests from the classes above. Please see comments before test methods for details on what testing is performed by each test.

## Authors

* **Zeeshan Khan** - *Initial work* - [KhanZee](https://github.com/KhanZee)

## Todo

 Write MORE Tests
