// swift-tools-version:5.3
import PackageDescription

let remoteKotlinUrl = "https://maven.pkg.github.com/levibostian/KMP-Blanky/earth/levi/shared-kmmbridge/19bd96d158/shared-kmmbridge-19bd96d158.zip"
let remoteKotlinChecksum = "b1cb05f3c88bf7ad4937a1225d25a32e8f52f472fa9553fa0e3274471db15960"
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