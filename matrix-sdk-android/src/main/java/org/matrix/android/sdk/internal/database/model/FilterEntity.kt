/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.database.model

import io.realm.kotlin.types.RealmObject

/**
 * Contain a map between Json filter string and filterId (from Homeserver).
 * Currently there is only one object in this table.
 */
internal class FilterEntity : RealmObject {
    // The serialized FilterBody
    var filterBodyJson: String = ""

    // The serialized room event filter for pagination
    var roomEventFilterJson: String = ""

    // the id server side of the filterBodyJson, can be used instead of filterBodyJson if not blank
    var filterId: String = ""

    companion object
}
