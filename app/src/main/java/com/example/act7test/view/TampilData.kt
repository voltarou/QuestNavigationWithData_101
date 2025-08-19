package com.example.act7test.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.act7test.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(onBackBtnClick: () -> Unit) {
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_lengkap), second = "Bening Namira"),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = "Laki-laki"),
        Pair(first = stringResource(id = R.string.alamat), second = "Yogyakarta")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.tampilan_data), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.teal_700))
            )
        }
    ) { paddingValues ->
        IsiRuang(paddingValues = paddingValues, items = items, onBackBtnClick = onBackBtnClick)
    }
}

@Composable
fun IsiRuang(paddingValues: PaddingValues, items: List<Pair<String, String>>, onBackBtnClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
    ) {
        items.forEach { item ->
            Column {
                Text(text = item.first.uppercase(), fontSize = 16.sp)
                Text(
                    text = item.second,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 22.sp
                )
            }
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onBackBtnClick
        ) {
            Text(text = "Back")
        }
    }
}