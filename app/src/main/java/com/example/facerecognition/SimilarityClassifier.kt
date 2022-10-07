package com.example.facerecognition

import java.util.Objects

public interface SimilarityClassifier {
    class Recognition {
        private final var id: String? = null
        private final var title: String? = null
        private final var distance: Float = 0.toFloat()
        private var extra: Objects?

        constructor(id: String?, title: String?, distance: Float, extra: Any?) {
            this.id = id
            this.title = title
            this.distance = distance
            this.extra = null
        }

        fun setExtra(extra: Objects?) {
            this.extra = extra
        }

        fun getExtra(): Objects? {
            return this.extra
        }

        override fun toString(): String {
            var resultString = ""
            if (id != null) {
                resultString += "[$id] "
            }
            if (title != null) {
                resultString += "$title "
            }
            if (distance != null) {
                resultString += String.format("(%.1f%%) ", distance * 100.0f)
            }
            return resultString.trim { it <= ' ' }
        }
    }
}