
public void validateSearchOrderWithArticleNumber(Validator validator) {
    Assert.assertTrue(
        validator.getActual().getAsJsonObject("result").getAsJsonArray("data").size() > 0,
        "Search order results should not be empty");
    Boolean articlePresentInSearchResult = false;
    for (JsonElement orderInfo :
        validator.getActual().getAsJsonObject("result").getAsJsonArray("data")) {
      if (validator
          .getExpected()
          .get("articleNumber")
          .getAsString()
          .equals(orderInfo.getAsJsonObject().get("articleNumber").getAsString())) {
        articlePresentInSearchResult = true;
        break;
      }
    }
    Assert.assertTrue(articlePresentInSearchResult, "Article id should match in search results");
  }
  
  
  
public void validateProductArticleTypePositive(Validator validator) {
    Assert.assertTrue(
        validator.getActual().getAsJsonObject("result").getAsJsonArray("data").size() > 0,
        "Edit price row popup input values should not be empty");
    for (JsonElement priceInfo :
        validator.getActual().getAsJsonObject("result").getAsJsonArray("data")) {
      Assert.assertEquals(
          priceInfo.getAsJsonObject().get("mrp").getAsString(),
          validator.getExpected().get("mrp").getAsString(),
          "Mrp should match");
      Assert.assertEquals(
          priceInfo.getAsJsonObject().get("price").getAsString(),
          validator.getExpected().get("price").getAsString(),
          "Price should match");
      Assert.assertEquals(
          priceInfo.getAsJsonObject().get("costBasedPrice").getAsString(),
          validator.getExpected().get("costBasedPrice").getAsString(),
          "Cost based price should match");
      Assert.assertEquals(
          priceInfo.getAsJsonObject().get("absolutePrice").getAsString(),
          validator.getExpected().get("absolutePrice").getAsString(),
          "Absolute price should match");
    }
  }
  
  
  
  public void validateSearchOrderNegative(Validator validator) {
    String noSearchResultsText =
        this.getAppDriver().getText(this.getPageLocator().noSearchResultsText());
    Assert.assertNotNull(noSearchResultsText, "Search order results should not be empty");
    Assert.assertEquals(
        this.getAppDriver().getText(this.getPageLocator().noSearchResultsText()),
        validator.getExpected().get("orderStatus").getAsString(),
        "Order status should match");
  }
  