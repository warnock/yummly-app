# _Meat_

### By Megan Warnock
#### Android Application, 5/26/17
Current Version: 1.0

![Meat Recipe Finder: Main Activity](/app/src/main/res/raw/main.png?raw=true "Meat Recipe Finder - Main Activity")
![Meat Recipe Finder: Recipe List](/app/src/main/res/raw/list.png?raw=true "Meat Recipe Finder - Recipe List")
![Meat Recipe Finder:  Recipe Detail](/app/src/main/res/raw/detail.png?raw=true "Meat Recipe Finder - Recipe Detail")

## Description

#### This Android application will allow new and repeat users to search for recipes. The app uses the Yummly API to search the users inputted ingredient and pull a list or recipes. A user will also be able to log in and save their favorite recipes for future use.

## Setup

Clone this repository:
* git clone `https://github.com/warnock/meat.git`
* you will need the current version of Andriod Studios to run this application:
    `https://developer.android.com/studio/index.html` (2.3.2 or higher)
* open project in Andriod Studios
* to run preview of app select the green play button in the tool bar or click "Run" -> "Run 'app'"
    * a box will pop open and select "Create New Virtual Device"
    * pick device you would like to run a simulation on (app was tested on Nexus 5X)
    * select "Marshmallow" as your system image and click next
    * press finish and run the application

This application uses the Yummly API. You will need to sign up to get a Yummly API key and ID at:

* `https://developer.yummly.com/`

once you have been given your key and ID you will need to put that information in the gradle.properties file:

* YummlyApiKey = "Your API KEY"
* YummlyAppId = "Your ID"

You can find more information about uses of the Yummly API here: `https://developer.yummly.com/documentation`

## Support and contact details

_Please contact Megan if any questions: megandwarnock@gmail.com_

## Known Bugs
None at this time

## Further things to improve app

* MEAT logo
* set up user input not to take numbers
* add error checks

## Technologies Used

Android Studios

Java

### License

This application is licensed under the MIT license

Copyright (c) 2017 **Megan Warnock**
