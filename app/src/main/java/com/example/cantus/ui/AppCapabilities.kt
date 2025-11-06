package com.example.cantus.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cantus.R

@Composable
fun AppCapabilitiesScreen(
    onGetStartedButtonClicked: () -> Unit,
    modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header section
        item {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_to_cantus),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displaySmall,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = stringResource(id = R.string.welcome_description),
                    modifier = Modifier.fillMaxWidth(.8f),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }

        item { Spacer(modifier = Modifier.height(12.dp)) }

        // App Capabilities Section
        item {
            CapabilitiesCard(
                R.drawable.musical_note,
                R.string.song_inventory,
                R.string.song_inventory_description
            )
        }
        item {
            CapabilitiesCard(
                R.drawable.folder,
                R.string.category_stewardship,
                R.string.category_stewardship_description
            )
        }
        item {
            CapabilitiesCard(
                R.drawable.line_chart,
                R.string.singing_insights,
                R.string.singing_insights_description
            )
        }
        item {
            CapabilitiesCard(
                R.drawable.calendar,
                R.string.service_planning,
                R.string.service_planning_description
            )
        }
        item {
            CapabilitiesCard(
                R.drawable.history,
                R.string.singing_history,
                R.string.singing_history_description
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        // Button
        item {
            Button(
                modifier = Modifier.fillMaxWidth(.9f),
                onClick = { onGetStartedButtonClicked() },
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(stringResource(R.string.get_started_button))
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

    }
}

@Composable
fun CapabilitiesCard(iconId: Int, titleId: Int, descriptionId: Int) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth(.8f)
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(titleId),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = stringResource(descriptionId),
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}