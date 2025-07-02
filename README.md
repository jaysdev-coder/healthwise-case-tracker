# HealthWise Case Tracker

HealthWise Case Tracker is an Android application designed to help users track and analyze health-related case statistics. The app provides insights into case data by age group, gender, health authority, and date, offering a clear and interactive way to visualize and explore trends.

## Features
- **User Authentication:** Secure login and registration using Firebase Authentication.
- **Case Data Visualization:** View and analyze case statistics by age, gender, health authority, and month/year.
- **Modern UI:** Clean, user-friendly interface with custom backgrounds and intuitive navigation.
- **Progress Dialogs:** Smooth user experience with loading indicators during data operations.
- **Firebase Integration:** Real-time data storage and retrieval using Firebase Realtime Database.

## Main Screens
- **Login/Register:** Secure user authentication.
- **Main Dashboard:** Overview of available case data and navigation to detailed views.
- **By Age, Gender, Health Authority, Month/Year:** Detailed breakdowns and statistics for each category.

## Project Structure
- `app/src/main/java/com/healthwise/casetracker/` — Main application source code
- `app/src/main/res/` — Layouts, drawables, and resources
- `app/src/androidTest/` and `app/src/test/` — Instrumented and unit tests

## Getting Started
1. **Requirements:**
   - Android Studio (latest recommended)
   - Java 17 (or compatible LTS version)
   - Firebase project setup (update `google-services.json` as needed)
2. **Build & Run:**
   - Clone the repository
   - Open in Android Studio
   - Sync Gradle and run on an emulator or device

## Customization
- Update Firebase configuration in `google-services.json` for your own project.
- Modify layouts and resources in `app/src/main/res/` to change the look and feel.

## License
This project is for educational and demonstration purposes. Please update the license as needed for your use case.
