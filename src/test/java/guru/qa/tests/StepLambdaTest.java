package guru.qa.tests;

import com.codeborne.selenide.Condition;
import guru.qa.testData.RepoData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepLambdaTest extends TestBase {

    RepoData repoData = new RepoData();

    @Test
    @Owner("pro100Nurs")
    @Feature("GitHub Issue")
    @Story("Лямбда шаги через step")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест на проверку номера Issue в репозитории (StepLambda)")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueRepo() {
        step("Открываем страницу " + repoData.url, () -> {
            open(repoData.url);
        });
        step("Поиск нужного репозиторий " + repoData.repoName, () -> {
            $(".header-search-input").setValue(repoData.repoName).pressEnter();
        });
        step("Переходим в репозиторий", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });
        step("Открываем вкладку Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем что существует Issue с номером " + repoData.issueNumber, () -> {
            $(withText("#" + repoData.issueNumber)).should(Condition.visible);
        });
    }
}
