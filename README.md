Namma Platform is a railway assistance Android application that helps users quickly access train and platform information in a simple and efficient way. When the app is opened, the user is taken to the home screen where they can search for a train or view platform details. After entering the train name or number, the app fetches the relevant data from a database such as Firebase or local storage. It then displays information like train name, source, destination, and platform number. This helps passengers easily identify where their train will arrive and reduces confusion inside railway stations. The app is designed to provide fast, accurate, and user-friendly navigation for a smooth travel experience.

Table of Contents

1. Problem Statement
2. Vision
3. Key Features and User Flow
4. Technical Implementation
5. App Screenshots
6. Impact Goals
7. Success Criteria
8. How to Run

1.Problem Statement

Passengers often face difficulties in getting real-time and organized railway-related information such as platform details, train status, and navigation inside stations. This leads to confusion, delays, and inefficient travel experience. **Namma Platform** is designed to simplify railway navigation and improve passenger experience through a digital solution.

Vision

The vision of Namma Platform is to build a smart railway assistance system that helps passengers easily access platform information, train updates, and station guidance in a simple and user-friendly way. The goal is to make railway travel more efficient, organized, and stress-free.

3.Key Features and User Flow

 Key Features:

* Train and platform information display
* Easy navigation for passengers inside stations
* Real-time updates (if integrated)
* Simple and clean user interface
* Quick access to essential railway details
* User-friendly design for all age groups

User Flow:

1. User opens the Namma Platform app
2. User lands on home/dashboard screen
3. User searches or selects train/route details
4. System displays platform and train information
5. User views updates and navigates accordingly
6. User completes travel smoothly using provided info

4. Technical Implementation

Frontend:

* Android application developed using Kotlin + XML
* Material Design UI components
* Simple navigation between screens

Backend:

* Firebase / Local database (based on implementation)
* Stores train, platform, and user-related data
* Supports fast retrieval of information

 Database Structure:

| Collection Name | Field       | Description             |
| --------------- | ----------- | ----------------------- |
| Trains          | trainId     | Unique train identifier |
| Trains          | trainName   | Name of the train       |
| Trains          | source      | Starting station        |
| Trains          | destination | Ending station          |
| Platform        | platformNo  | Platform number         |
| Platform        | trainId     | Linked train            |
| User            | userId      | Unique user ID          |
| User            | email       | Login email             |
| User            | password    | Authentication data     |


5. App Screenshots

<img width="1625" height="701" alt="image" src="https://github.com/user-attachments/assets/fde53395-2d1f-4489-82bb-1477e0d86b09" />

<img width="325" height="661" alt="image" src="https://github.com/user-attachments/assets/44b8323f-73fc-4f79-959b-5bd5edac8c5e" />
<img width="332" height="661" alt="image" src="https://github.com/user-attachments/assets/93d98057-9332-40a2-b058-fa8d49370405" />
<img width="314" height="661" alt="image" src="https://github.com/user-attachments/assets/c91fce9c-db3b-44a5-b768-8f8191c3d305" />


6. Impact Goals

* Reduce confusion in railway stations
* Improve passenger travel experience
* Provide quick and reliable platform information
* Support digital transformation in railway services
* Save time for commuters
  
7.  Success Criteria

* App runs smoothly without errors
* Correct train and platform information is displayed
* Fast response time for user queries
* Easy navigation and user-friendly UI
* System works consistently with minimal downtime

8. How to Run

Steps:

https://github.com/Malleswari0924/Nammaplatform


1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Connect emulator or physical Android device
4. Click Run to launch the app


