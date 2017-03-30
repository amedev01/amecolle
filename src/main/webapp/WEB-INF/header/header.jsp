<%@page contentType="text/html" pageEncoding="UTF-8" session="false" %>

 	<!-- ホームへのリンク -->
	<form action="home" method="post">
		<input type="submit" value="ホーム" >
	<!-- アカウント編集画面へのリンク -->
		<input type="submit" value="アカウント" formaction="accountEdit">
	<!-- デッキ編集画面へのリンク -->
		<input type="submit" value="デッキ" formaction="deckHome">
	<!-- バトル画面へのリンク -->
		<input type="submit" value="バトル" formaction="battleHome">
	<!-- ガチャ画面へのリンク -->
		<input type="submit" value="ガチャ" formaction="gachaHome">
	<!-- 	ログアウト	 -->
		<input type="submit" value="ログアウト" formaction="logout">
	</form>
