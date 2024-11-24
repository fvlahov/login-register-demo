### Login/registration demo and image list view using fragments/XML and data-binding

## How to start application
- Make sure you have JDK version of atleast 17 and set your Android Studio JDK version through **Settings -> Build, Execution Deployment -> Build Tools -> Gradle -> Gradle JDK**
- Set **Build Variant** to debug (did not test in release)
- Build and start on emulator/physical device
- Mock email and password used for Login
  - Email: test@test.com
  - Password: 123456
- Registration will always succeed (after validation)

## Architecture
- Hilt for DI
- MVVM
- Clean Architecture (app, data, domain modules)
- Repository + Use case pattern
- Version catalog for dependency management
- XML, fragments and data-binding for UI
- Retrofit/OkHttp for API calls
- Paging3 for pagination

**Enjoy!**
