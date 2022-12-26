// swift-tools-version:5.3
import PackageDescription

let remoteKotlinUrl = "https://maven.pkg.github.com/levibostian/KMP-Blanky/earth/levi/shared-kmmbridge/b1845f1240/shared-kmmbridge-b1845f1240.zip"
let remoteKotlinChecksum = "650483c917d21647102f5bbbc065628b94a3482cf221aa2dc6f8349e18fa920f"
let packageName = "dropbox"

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)