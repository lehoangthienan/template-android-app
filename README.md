# Android Boilerplate

> This is a boilerplate project for android mobile app

You can use the samples in this project as a learning reference, or as a starting point for creating your own apps. The focus of this project is on demonstrating how to structure your code, design your architecture, and the eventual impact of adopting these patterns on testing and maintaining your app. You can use the techniques demonstrated here in many different ways to build apps. Your own particular priorities will impact how you implement the concepts in these projects, so you should not consider these samples to be canonical examples. To ensure the focus is kept on the aims described above, the app uses a simple UI.

This repo contains the following samples:

[MVP Sample](https://github.com/dwarvesf/template-android-app/tree/master/mvp) Demonstrates a basic MVP architecture and provides a foundation on which the other samples are built. This sample also acts as a reference point for comparing and contrasting the other samples in this project.

[MVVM Sample](https://github.com/dwarvesf/template-android-app/tree/master/mvvm-rx) Based on the MVVM best practice: Inputs - Outputs, this version incorporates the MVVM pattern. 

[Clean Architecture Sample](https://github.com/dwarvesf/template-android-app/tree/master/mvvm)  A basic implementation of Clean Architecture and Model-View-Presenter Architecture on android


## Usage

### 1. Clone template from git
```
git clone git@github.com:dwarvesf/template-android-app.git
```

### 2. Install `python`

#### Windows

Follow official guide: 

https://www.python.org/downloads

#### Mac, Ubuntu

`python` is already pre-installed.

### 3. Install `pip`

#### Windows

`pip` is already pre-installed with `python`.

#### MacOS/ Ubuntu

`python -m ensurepip --default-pip`

### 4. Install `pystache`

`pip install pystache`

### 5. (Optional) Fabric crashlytics

If you need a crash reporting service, you can register a fabric account and get an API key at:

https://get.fabric.io

### 6. (Optional) Google Maps

If you want to use Google Maps, you need to get an API key with your google account at:

https://developers.google.com/maps/documentation/android-sdk/signup

### 7. Generate project

`python kickstart.py` 

and follow the guide.

After successful creating, your project can be located at `/project`


## Features

- [x] Login page
- [x] Map page
- [x] List page
- [x] Detail page

## License

MIT &copy; [Dwarves Team](github.com/dwarvesf)
