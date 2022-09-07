package pl.britenet.cli.command;

import pl.britenet.cli.Constants;
import pl.britenet.cli.model.Product;
import pl.britenet.cli.model.builder.ProductBuilder;

public class HelloCommand extends Command {

    public HelloCommand() {
        super(Constants.COMMAND_HELLO);
    }

    @Override
    public void execute() {
        Product product = new ProductBuilder()
                .setId(0)
                .setName("Test")
                .setDescription("Test Desc")
                .setPrice(100)
                .getProduct();
    }
}
