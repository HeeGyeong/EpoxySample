package com.example.epoxysample.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.epoxysample.model.Title


@Composable
fun ComposeRecyclerView() {
    val scaffoldState = rememberScaffoldState()

    val dummyData = ArrayList<Title>()
    dummyData.add(Title("1"))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar2("EpoxySample")
        },
        content = {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemList(dummyData)
            }
        }
    )
}

@Composable
fun ItemList(itemList: List<Title>) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier.padding(bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(itemList) { index, item ->
            if (index == 3) {
                ItemList2(itemList)
            } else {
                CardView2(item)
            }
        }

        items(itemList) { item ->
            item.title
        }
    }
}

@Composable
fun ItemList2(itemList: List<Title>) {
    val scrollState = rememberLazyListState()

    LazyRow(
        state = scrollState,
        modifier = Modifier.padding(bottom = 10.dp),
    ) {
        itemsIndexed(itemList) { _, item ->
            CardView2(item)
        }

        items(itemList) { item ->
            item.title
        }
    }
}

@Composable
fun CardView2(msg: Title) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Column(
            modifier = Modifier
                .padding(all = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = msg.title,
            )
        }
    }
}

@Composable
fun TopBar2(
    title: String,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}