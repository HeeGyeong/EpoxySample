package com.example.epoxysample.compose

import androidx.compose.foundation.ExperimentalFoundationApi
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
    for (index in 0..20) {
        dummyData.add(Title("$index"))
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar("EpoxySample")
        },
        content = {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GridItemList(dummyData)
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
            when (index) {
                3, 6 -> {
                    RowItemList(itemList)
                }
                else -> {
                    ItemView(item)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridItemList(itemList: List<Title>) {
    LazyVerticalGrid(cells = GridCells.Fixed(3)) {
        items(itemList) { item ->
            Text(
                text = item.title,
            )
        }
    }
}

@Composable
fun RowItemList(itemList: List<Title>) {
    val scrollState = rememberLazyListState()

    LazyRow(
        state = scrollState,
        modifier = Modifier.padding(bottom = 10.dp),
    ) {
        items(itemList) { item ->
            ItemView(item)
        }
    }
}

@Composable
fun ItemView(msg: Title) {
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
fun TopBar(
    title: String,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}