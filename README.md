# Ventum

## Introduction

Ventum is a gamified platform for purchasing and using city transit passes. A local government may partner with Ventum to create their own utility NFTs on the Solana blockchain, which will have metadata properties to allow residents to access parking spaces, lots, trains, busses, and more. Residents may transfer their NFTs from their wallet to a friends. The city may also choose to deploy special discount NFTs (e.g. for puchasing one 3 month pass) and unique event integrations (such as a New Years event, where residents purchase a NYE-NFT whose proceeds go entirely to charity, and which entitles users to a free meal or beverage on New Years Eve at participating local restaurants).

Naming inspiration came from Chicago's transit card "Ventra". This was derived from the Latin "ventosa," or "windy," a reference to the Chicago's title of The Windy City. Ventum is the accusative singular, meaning "to blow," giving action and motion to the wind and not just functioning as a descriptor.


## Status

This project is currently under development. As of now the only feature implemented is the crypto market view. The app fetches the current market price in USD of BTC, ETH, and SOL, and displays them to the user. A "swap" button is also displayed, which will soon display different cryptocurrencies on press.

Priority future updates will be based around a decision whether to deploy exclusively on the Solana blockchain, exclusively on Stacks via CityCoins, or adding cross-chain compatibility.

The planned logo will be of a wheel speeding against a city skyline, with a color scheme matching the city flag. 

Integration with DeSci is also under consideration. Decentralized science via cryptocurrency and NFT platforms will enable patients and families directly
fund scientists researching and developing treatments to diseases affecting them. This integration may be in addition to or in lieu of discounts at local restaurants and businesses.


## Challenge notes

Prior to Ventum I had never written code in Kotlin. The greatest challenge was setting up the emulator; I've included a guide below to describe the setup I got it working in, with the hopes it could help someone else.

I chose Android Studio over Intellij IDEA, as the Android dev features will always be the latest relative to Android plugin in IntelliJ, it itself is a fork of IntelliJ optimized for Android development with an embedded JDK, Android hierarchy in project view, and new project wizard.


	- imports (Row, Column, painter: contentDescription throwing error because previous line did not end in ',')

	- how many things you must import (dp unit, Clip method)

	- gradle build => emulator, instead of 'npm start'

	-resource intensive and the time it takes: a couple minutes to compile, space req's, using external hard drive on my Macbook Air

	-AVD emulator: "system UI isn't responding", working on getting emulator running in addition to building and quickly iterating on app, Preview window somewhat works but not enough

	-setting OSX env var's to store AVDs on external SSD

	-editing with emulator: some changes not immediately reflected

	-Suspend function 'ping' should be called only from a coroutine or another suspend function, && suspend functions cannot be made composable

	-confusing documents that don't explain how to handle unique data types

	-making HTTP request and handling response: storing and retrieving data

	-web frameworks "just work", but in Kotlin it's not just "write fetch and store the result in an object"

	-check your module classpath for missing or conflicting dependencies

	-having to import so many things: just importing viewModels, had to add dependencies to gradle

	-coroutine scope

	-similar to heavy NPM packages, lots of time spent building emulator

	-code should all be correct but emulator just won't build- "system UI isn't responding", workarounds intermittently working

	-Fatal exception: main => : baseUrl must end in /


## Android Studio Emulator notes

	Pixel 4 XL API 31

	select hardware in the graphics drop down
	x86_64 image
	cold boot
	Pixel 4 

	increase RAM from 512 to 1024

	run in a separate window instead of the doc

	Start the emulator first, then click "run app" and choose the emulator as the target device



## Lesson notes


	Retrofit to make REST API calls, Moshi to handle deserialization of JSON to Kotlin data objects

	ViewModel
	LiveData
	Data Binding with binding adapters

	coroutines and fragments

	-types, similar to typescript

	-JVM versus v8 engine, virtual DOM on web

	-android studio logically grouping source code/resources for each module into 'source sets'

	-code templates that follow design/dev best practices

	-app component types: Activities, Services, Broadcast receivers, Content providers

	-Composable functions: define app UI describe appearance and data dependencies instead of focusing on constructing (init element, attach to parent etc)

	- I like the C syntax, Material Design widgets, OOP/ comments/ similarities to webdev, Android Studio IDE showing BTC image on side

	-styles and themes vs CSS

	-Maven repository, adding CoinGecko API dependency

	-coroutines, suspend functions

	-best practice: separation of concerns, drive UI from data models

	-UI Layer and Data Layer

	-MVVM: two-way bind data in views

	-Compose: declarative UI, not imperative

	-Compose takes in data and emits UI

	-Enable bi-directional data binding Google library

	-build tools and languages/ frameworks: Maven, Gradle, Groovy

	-bad docs (Coingecko Kotlin API wrapper) vs good docs (Moshi)

	-AppCompatActivity (extends FragmentActivity -> ComponentActivity, uses fragments) vs ComponentActivity (Compose-only app)

	-packages and package imports (market, network)
 
 	-learning to use IDE debugger, vs console.error in web dev


## Technologies

Ventum is created with:

- Kotlin
- Jetpack Compose
- Gradle
- Groovy 
- Maven

