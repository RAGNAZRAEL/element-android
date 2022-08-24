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
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey
import org.matrix.android.sdk.api.session.room.model.Membership
import org.matrix.android.sdk.api.util.MatrixItem
import org.matrix.android.sdk.internal.database.model.presence.UserPresenceEntity

internal class RoomMemberSummaryEntity : RealmObject {
    @PrimaryKey var primaryKey: String = ""
    @Index var userId: String = ""
    @Index var roomId: String = ""
    @Index var displayName: String? = null
    var avatarUrl: String? = null
    var reason: String? = null
    var isDirect: Boolean = false

    private var membershipStr: String = Membership.NONE.name
    var membership: Membership
        get() {
            return Membership.valueOf(membershipStr)
        }
        set(value) {
            membershipStr = value.name
        }

    var userPresenceEntity: UserPresenceEntity? = null
        set(value) {
            if (value != field) field = value
        }

    fun toMatrixItem() = MatrixItem.UserItem(userId, displayName, avatarUrl)

    companion object
}
