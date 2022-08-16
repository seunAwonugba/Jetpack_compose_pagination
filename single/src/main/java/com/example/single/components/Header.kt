package com.example.single.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    fullName : String,
    navBack : () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "",
            modifier = Modifier.clickable {
                navBack()
            }
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Text(
            text = fullName,
            fontSize = 24.sp
        )
    }

}