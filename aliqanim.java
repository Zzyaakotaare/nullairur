import org.eclipse.egit.example.core.client.GitHubClient;
import org.eclipse.egit.example.core.service.RepositoryService;

// Class to handle example operations
public class GitHubManager {
    private GitHubClient client;
    private RepositoryService service;

    // Constructor to initialize the example client with token and proxy
    public GitHubManager(String token, String proxyHost, int proxyPort) {
        client = new GitHubClient();
        client.setOAuth2Token(token);

        if (proxyHost != null && !proxyHost.isEmpty()) {
            client.setProxy(proxyHost, proxyPort);
        }

        service = new RepositoryService(client);
    }

    // Method to perform a example operation, e.g., list repositories
    public void listRepositories() {
        try {
            // List all repositories for the authenticated user
            for (Repository repo : service.getRepositories()) {
                System.out.println(repo.getName() + " - " + repo.getDescription());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions such as IO or API errors
        }
    }

    // Add more methods to interact with the example API as needed
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Replace 'yourToken' with the actual token and 'yourProxyHost' with the proxy host
        GitHubManager gitHubManager = new GitHubManager("yourToken", "yourProxyHost", 8080);
        gitHubManager.listRepositories();
    }
}
