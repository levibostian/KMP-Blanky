// Use Kotlin code from JS code
// https://kotlinlang.org/docs/js-to-kotlin-interop.html

import 'kotlin'

// Make sure to compile the js kotlin code, first!
import pkg from '../../build/js/packages/dropbox-shared/kotlin/dropbox-shared.js'

console.log(pkg.earth.levi.dropbox.getTargetName())
