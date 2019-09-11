package issue;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DefaultDockerClientConfig.Builder;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.netty.NettyDockerCmdExecFactory;

public class Issue {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("The app expects one argument - the image tag.");
            System.exit(1);
        }

        String imageTag = args[0];
        String id = new Issue().getId(imageTag);
        System.out.println("Image ID: " + id);

    }

    public String getId(String imageTag) {
        Builder configBuilder = DefaultDockerClientConfig.createDefaultConfigBuilder();
        DockerClientConfig config = configBuilder.build();
        DockerClient client = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(new NettyDockerCmdExecFactory()).build();
        return client.inspectImageCmd(imageTag).exec().getId();
    }
}
