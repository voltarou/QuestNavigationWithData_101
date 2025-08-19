package com.example.act7test.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.act7test.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IsiRuang(
    onSubmitButtonClicked: (ArrayList<String>) -> Unit
) {
    var txtNama by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }

    val pilihanJK = listOf("Laki-laki", "Perempuan")
    val listData = arrayListOf(txtNama, txtGender, txtAlamat)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.form_pendaftaran), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = colorResource(id = R.color.purple_500))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = txtNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { txtNama = it }
            )

            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .padding(all = 12.dp)
                    .width(250.dp)
            )

            // Gender selection
            Column(
                modifier = Modifier.width(250.dp)
            ) {
                Text(text = "Jenis Kelamin")
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = txtGender == item,
                                onClick = { txtGender = item }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier
                    .padding(all = 5.dp)
                    .width(250.dp)
            )

            OutlinedTextField(
                value = txtAlamat,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = { txtAlamat = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(fraction = 0.8f),
                enabled = txtNama.isNotEmpty() && txtAlamat.isNotEmpty() && txtGender.isNotEmpty(),
                onClick = { onSubmitButtonClicked(listData) }
            ) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIsiRuang() {
    IsiRuang(
        onSubmitButtonClicked = {}
    )
}