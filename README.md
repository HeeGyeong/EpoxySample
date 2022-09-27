# EpoxySample

Airbnb에서 제공하는 라이브러리인 Epoxy를 사용해 본 샘플 프로젝트 입니다.

DataBinding을 사용하지 않았을 경우에 사용하는 DataModel, Controller에 대한 구현도 해두었으나 DataBinding을 사용하도록 변경한 후 주석처리 해두었습니다.

* 동일한 느낌의 UI를 그릴 수 있는 3가지 방법 대하여 간단하게 구현하고 패키지를 나누어 구분하였습니다.

* 각 방법마다 사용하는 방식과, 구현되는 코드의 양 등을 비교해보기 위하여 작성하였습니다. 

## RecyclerView vs Epoxy vs Compose
일반적인 RecyclerView와 Adapter, ViewHolder를 사용하여 구현하는 방식과, Epoxy를 사용하는 방식, Compose를 사용하는 방식으로 나누어 비슷한 형태의 기본 UI를 그렸습니다.

세로 스크롤, 가로 스크롤에 대한 기본적인 구현과, Compose와 Epoxy에서는 GridLayout에 관련된 코드까지 추가하였습니다.

Data는 각각 타입마다 필요한 개수 만큼만 별도로 생성하여 보여질 수 있도록 구현했습니다.

## Blog
Epoxy에 대한 사용 방법 및 설명은 다음 블로그에 작성해 두었습니다.

[Tistory Blog](https://heegs.tistory.com/136 "Epoxy Basic usage")
