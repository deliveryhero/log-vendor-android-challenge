## Logistics · Vendor · Android Challenge

A sample app that we use for challenging our candidates. It's based on [Google's Sunflower sample](https://github.com/android/sunflower).

### What's inside?

- Android Jetpack (Foundation, Arch, AppCompat, Test, KTX...)
- Gradle (for building)
- Kotlin (the main language)
- Tests (some coverage)
- Unsplash integration (see below)
- Android UI framework (Fragments, Animations/Transitions, Layout...)
- Dagger + Hilt (DI)
- Coroutines (for async work)
- KtLint setup

### Unsplash API

This app uses the [Unsplash API](https://unsplash.com/developers) to load images on the gallery
screen. To use the API, you will need to obtain a free developer API key. See the
[Unsplash API Documentation](https://unsplash.com/documentation) for instructions.

Once you have the key, add the following line to the `local.properties` file in the project's root folder:

```
unsplash_access_key=YOUR_UNSPLASH_KEY_GOES_HERE
```

The app is still usable without an API key, but you won't be able to navigate to the gallery screen.

### Screenshots

![List of plants](screenshots/phone_plant_list.png "A list of plants")
![Plant details](screenshots/phone_plant_detail.png "Details for a specific plant")
![My Garden](screenshots/phone_my_garden.png "Plants that have been added to your garden")

### KtLint Setup

- Download KtLint using [these installation instructions](https://github.com/pinterest/ktlint/blob/master/README.md#installation)
- Apply KtLint settings to Android Studio using [these instructions](https://github.com/pinterest/ktlint/blob/master/README.md#-with-intellij-idea)
- Restart Android Studio (just in case)

### Third Party Content

Select text used for describing the plants (in `plants.json`) are used from Wikipedia via CC BY-SA 3.0 US (license in `ASSETS_LICENSE`).

"[Seed](https://thenounproject.com/search/?q=seed&i=1585971)" by [Aisyah](https://thenounproject.com/aisyahalmasyira/)
is licensed under [CC BY 3.0](https://creativecommons.org/licenses/by/3.0/us/legalcode)