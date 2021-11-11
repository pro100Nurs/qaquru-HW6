package guru.qa.tests;

import guru.qa.steps.GithubTestSteps;
import guru.qa.testData.RepoData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest extends TestBase {

    GithubTestSteps steps = new GithubTestSteps();
    RepoData repoData = new RepoData();

    @Test
    @Owner("pro100Nurs")
    @Feature("GitHub Issue")
    @Story("Шаги с аннотацией @Step")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест на проверку номера Issue в репозитории (StepAnnotated)")
    @Link(name = "GitHub", url = "https://github.com")
    public void checkIssueRepo() {
        steps.openPage(repoData.url)
                .searchRepo(repoData.repoName)
                .goToRepo()
                .openIssuesTab()
                .shouldIssueWithNumber(repoData.issueNumber);
    }
}
