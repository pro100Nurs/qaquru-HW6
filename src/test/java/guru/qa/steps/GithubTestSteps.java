package guru.qa.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTestSteps {

    private SelenideElement
            searchInput = $(".header-search-input"),
            issuesTab = $("#issues-tab");

    private ElementsCollection
            repoLink = $$("ul.repo-list li");

    @Step("Открываем страницу {url}")
    public GithubTestSteps openPage(String url) {
        open(url);
        return this;
    }

    @Step("Поиск нужного репозиторий {repository}")
    public GithubTestSteps searchRepo(String repository) {
        searchInput.setValue(repository).pressEnter();
        return this;
    }

    @Step("Переходим в репозиторий")
    public GithubTestSteps goToRepo() {
        repoLink.first().$("a").click();
        return this;
    }

    @Step("Открываем вкладку Issues")
    public GithubTestSteps openIssuesTab() {
        issuesTab.click();
        return this;
    }

    @Step("Проверяем что существует Issue с номером {number}")
    public GithubTestSteps shouldIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
        return this;
    }
}
