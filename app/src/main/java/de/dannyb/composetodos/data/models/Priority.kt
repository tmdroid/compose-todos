package de.dannyb.composetodos.data.models

import androidx.compose.ui.graphics.Color
import de.dannyb.composetodos.ui.theme.HighPriorityColor
import de.dannyb.composetodos.ui.theme.LowPriorityColor
import de.dannyb.composetodos.ui.theme.MediumPriorityColor
import de.dannyb.composetodos.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor),
}
