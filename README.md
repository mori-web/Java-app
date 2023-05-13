# SpringBoot TodoApp
<!-- リポジトリネームを書く -->

## Overview
<!-- 概要 を書く-->
<!-- 簡単に1〜2行 -->
SpringBootフレームワークを用いたTodoアプリを作成

## Requirement
<!-- 要件を書く -->
<!-- 環境に必要な言語・ツール・ライブラリやバージョンを記載する -->
・java 17
・springboot 3.0.6

・implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
・implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
・implementation 'org.springframework.boot:spring-boot-starter-validation'
・implementation 'org.springframework.boot:spring-boot-starter-web'
・compileOnly 'org.projectlombok:lombok'
・developmentOnly 'org.springframework.boot:spring-boot-devtools'
・runtimeOnly 'org.postgresql:postgresql'
・annotationProcessor 'org.projectlombok:lombok'
・testImplementation 'org.springframework.boot:spring-boot-starter-test'

・postgres 14.7

## Usage
<!-- 使用方法を書く -->
<!-- 簡単な使い方・インストール方法など -->
```
mkdir demy
cd demy
git clone https://github.com/mori-web/SpringBoot-TodoApp.git
```



## Features
<!-- 特徴を書く -->
<!-- 詳しい仕様について基本的に箇条書きで書く -->
SpringBoot3にて簡単なTodoアプリを作成しました。
基本実装はCRUDを実装しています。
・新規作成
・一覧の情報を取得
・todoの編集
・削除 (削除時に確認画面を追加)


## Reference
<!-- リファレンス -->
<!-- 参考URLを書く -->

## Author
<!-- 著者名（自分の情報を書く） -->
<!-- Twitterアカウント -->
<!-- [twitter](https://twitter.com/kumaron_web) -->
mori-web

## Licence
<!-- 例：[MIT](https://......) -->

Thank you!