./gradlew :composeApp:linkDebugFrameworkIosSimulatorArm64 && \
xcodebuild -project iosApp/iosApp.xcodeproj \
  -scheme iosApp \
  -destination "id=A6B3662E-ACC1-4D59-91F6-75765CB4C251" \
  -configuration Debug build && \
xcrun simctl install A6B3662E-ACC1-4D59-91F6-75765CB4C251 \
  ~/Library/Developer/Xcode/DerivedData/iosApp-ekagnatosjptgubulgedaivgzyeq/Build/Products/Debug-iphonesimulator/FocusTasks.app && \
xcrun simctl launch A6B3662E-ACC1-4D59-91F6-75765CB4C251 com.bob.focustasks.FocusTasks
