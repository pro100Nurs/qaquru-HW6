package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.testData.RepoData;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideListenerTest extends TestBase {

    RepoData repoData = new RepoData();

    @Test
    @Owner("pro100Nurs")
    @Feature("GitHub Issue")
    @Story("Selenide с Listener")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест на проверку номера Issue в репозитории (SelenideListener)")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueRepo() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Открываем страницу GitHub
        open(repoData.url);

        // Поиск нужного репозиторий
        $(".header-search-input").setValue(repoData.repoName).pressEnter();

        // Переходим в репозиторий
        $$("ul.repo-list li").first().$("a").click();

        // Открываем вкладку Issues
        $("#issues-tab").click();

        // Проверяем что существует Issue с номером
        $(withText("#" + repoData.issueNumber)).should(Condition.visible);
    }
}
