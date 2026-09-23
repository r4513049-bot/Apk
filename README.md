# Origin Style - Android Customizer

An OriginOS 7-inspired customization app built with Kotlin + Jetpack Compose.
Works on any Android 7.0+ phone (minSdk 24), no root needed.

## Features

| Tab | What it does |
|---|---|
| **Themes** | Light / Dark / **AMOLED true-black** mode, 7 OriginOS-style accent colors, applied live inside the app |
| **Walls** | 12 bundled wallpapers: 7 anime, 2 dark aesthetic, 3 generated AMOLED-black. Tap to preview, then set to Home, Lock, or Both with one tap |
| **Icons** | Squircle / Rounded / Soft / Circle icon shapes with live preview + instructions to apply packs on Nova/Lawnchair |
| **Widgets** | OriginOS-style glance widgets (clock, real battery ring, weather, music) + a real homescreen clock widget |

## Build the APK

1. Install [Android Studio](https://developer.android.com/studio)
2. **File > Open** this folder
3. Wait for Gradle sync (downloads dependencies automatically)
4. **Build > Build APK(s)** -> find `app-debug.apk` in `app/build/outputs/apk/debug/`
5. Copy the APK to your phone and install (allow "install from unknown sources")

Or from the command line:

```bash
./gradlew assembleDebug
```

## Add your own wallpapers

Drop JPG/PNG files into `app/src/main/res/drawable-nodpi/`, then add one line
in `app/src/main/java/com/originstyle/customizer/data/Models.kt`:

```kotlin
WallpaperItem("My Wallpaper", R.drawable.my_wallpaper, WallCat.ANIME)
```

## Notes

- Setting wallpapers uses the standard `WallpaperManager` API (home + lock screen).
- Android does not let third-party apps restyle other launchers' icons system-wide;
  the Icons tab gives you the shape preview plus launcher instructions.
