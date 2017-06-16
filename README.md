# _Meat_

### By Megan Warnock 
#### Adroid Application, 5/26/17
Current Version: 1.0 

![MainActivity](/app/src/main/res/raw/mainactivity.png?raw=true "mainActivity")

## Description

#### This application will allows users to use the Yummly api to search recipes. A user will also be able to log in and star thier favorite recipes.

## Setup

Clone this repository:
* git clone `https://github.com/warnock/meat.git`
* you will need the current version of Adriod Studios to run this application: 
    `https://developer.android.com/studio/index.html` (2.3.2 or higher)
* open project in Adriod Studios
* to run preview of app select the green play button in the tool bar or click "Run" -> "Run 'app'"
    * a box will pop open and select "Create New Virtual Device"
    * pick device you would like to run a simulation on (app was tested on Nexus 5X)
    * select "Marshmallow" as your sysetme image and click next
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
* add Picasso and write method to make images clearer
* set up user input not to take numbers
* add if statement if no recipes returned

## Technologies Used

Andriod Studios

Java

### License

This application is licensed under the MIT license

Copyright (c) 2017 **Megan Warnock**
