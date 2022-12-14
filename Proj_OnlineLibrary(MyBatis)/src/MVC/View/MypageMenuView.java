package MVC.View;

import MVC.Controller.WithdrawController;
import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class MypageMenuView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		VBox topPane;
		FlowPane topInfoPane;
		FlowPane topPointPane;
		FlowPane topTierPane;
		VBox centerPane;
		
		// Components
		Label infoLabel;
		Label pointLabel;
		Label userPointLabel;
		Label tierLabel;
		Label userTierLabel;
		
		Button myBorrowStatButton;
		Button myBorrowLogButton;
		Button myInterBookButton;
		Button modifyMyInfoButton;
		Button withdrawButton;
		
		Button modifyBookDBButton;
		Button outstandingBookButton;
		Button customerListButton;
//		Button modifyWebsiteButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		topPane = new VBox();
		topInfoPane = new FlowPane();
		topPointPane = new FlowPane();
		topTierPane = new FlowPane();
		centerPane = new VBox();
		
		// Components
		infoLabel = new Label();
		pointLabel = new Label();
		userPointLabel = new Label();
		tierLabel = new Label();
		userTierLabel = new Label();
		
		myBorrowStatButton = new Button();
		myBorrowLogButton = new Button();
		myInterBookButton = new Button();
		modifyMyInfoButton = new Button();
		withdrawButton = new Button();
		
		modifyBookDBButton = new Button();
		outstandingBookButton = new Button();
		customerListButton = new Button();
//		modifyWebsiteButton = new Button();

		
		
		
		
		// View -----

		// Components
		infoLabel.setText("- ??? ?????? -");
		infoLabel.setPrefSize(160, 30);
		infoLabel.setAlignment(Pos.CENTER);
		infoLabel.setFont(Font.font(15));
		
		pointLabel.setText("????????? : ");
		pointLabel.setPrefSize(70, 30);
		userPointLabel.setText(String.valueOf(share.getUser().getPoint()));
		userPointLabel.setPrefSize(90, 30);
		userPointLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		
		tierLabel.setText("?????? : ");
		tierLabel.setPrefSize(70, 30);
		userTierLabel.setText(share.getUser().getTier());
		userTierLabel.setPrefSize(90, 30);
//		userTierLabel.setFont(Font.font("Viner Hand ITC", FontWeight.BOLD, 25));
		userTierLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		if (share.getUser().getId().equals("admin")) {
			userTierLabel.setTextFill(Color.DARKRED);
		}
		
		myBorrowStatButton.setText("??? ?????? ?????? & ??????");
		myBorrowStatButton.setPrefSize(160, 30);
		myBorrowStatButton.setOnAction(e -> {
			System.out.println("@@ ??? ?????? ?????? & ??????");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageBorrowStatView().getRootPane(share));
			share.getMainPane().setCenter(pane);
			
		});
		
		myBorrowLogButton.setText("??? ?????? ??????");
		myBorrowLogButton.setPrefSize(160, 30);
		myBorrowLogButton.setOnAction(e -> {
			
		});
		
		myInterBookButton.setText("??? ?????? ??????");
		myInterBookButton.setPrefSize(160, 30);
		myInterBookButton.setOnAction(e -> {
			
		});
		
		modifyMyInfoButton.setText("?????? ?????? ??????");
		modifyMyInfoButton.setPrefSize(160, 30);
		modifyMyInfoButton.setOnAction(e -> {
			System.out.println("@@ ?????? ?????? ??????");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageModifyMyInfoView().getRootPane(share));
			share.getMainPane().setCenter(pane);
//			share.getMypageView().getRootPane(share).setCenter(share.getModifyMyInfoView().getRootPane(share)); // ?????? ?????? ??? ???
		});
		
		withdrawButton.setText("????????????");
		withdrawButton.setPrefSize(160, 30);
		withdrawButton.setOnAction(e -> {
			System.out.println("@@ ?????? ??????");
			
			Dialog<String> dialog = new Dialog<String>();
	        dialog.setTitle("?????? ??????");
	        ButtonType typeYes = new ButtonType("???", ButtonData.YES);
		    ButtonType typeNo = new ButtonType("?????????", ButtonData.NO);
		    dialog.setContentText("?????????????????????????");
		    dialog.getDialogPane().getButtonTypes().add(typeYes);
		    dialog.getDialogPane().getButtonTypes().add(typeNo);
//		    dialog.setOnCloseRequest(e2 -> {
//		    	System.out.println("@@ dialog ??????");
//		    });
		    dialog.setResultConverter(new Callback<ButtonType, String>() {
				
				@Override
				public String call(ButtonType param) {
					if (param.getButtonData() == ButtonData.YES) {
						System.out.println("@@ ?????? ?????? ??????");
						WithdrawController controller = new WithdrawController();
						int rows = controller.withdrawAccount(share.getUser().getId());
						share.setUser(null);
						share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
						share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
					} else if (param.getButtonData() == ButtonData.NO) {
						System.out.println("@@ ?????? ?????? ??????");
					}
//					else if (param.getButtonData() == ButtonData.CANCEL_CLOSE) {
//						System.out.println("@@ Dialog param = cancel_close"); // ?????? ??? ?????? ??? ????????? ?????????
//					}
					return null;
				}
			});
		    dialog.showAndWait();

		});
		
		modifyBookDBButton.setText("?????? ?????????????????? ??????");
		modifyBookDBButton.setPrefSize(160, 30);
		modifyBookDBButton.setOnAction(e -> {
			System.out.println("@@ ?????? ?????????????????? ??????");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageModifyBookDBView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});

		outstandingBookButton.setText("?????? ??????");
		outstandingBookButton.setPrefSize(160, 30);
		outstandingBookButton.setOnAction(e -> {
			System.out.println("@@ ?????? ??????");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageOutstandingBookView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});
		
		customerListButton.setText("?????? ??????");
		customerListButton.setPrefSize(160, 30);
		customerListButton.setOnAction(e -> {
			System.out.println("@@ ?????? ??????");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageUserListView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});
		
//		modifyWebsiteButton.setText("????????? ??????");
//		modifyWebsiteButton.setPrefSize(160, 30);
//		modifyWebsiteButton.setOnAction(e -> {
//			
//		});
		


		
		
		// Layout
		topInfoPane.getChildren().add(infoLabel);
		topPointPane.getChildren().add(pointLabel);
		topPointPane.getChildren().add(userPointLabel);
		topTierPane.getChildren().add(tierLabel);
		topTierPane.getChildren().add(userTierLabel);
		
		topPane.getChildren().add(topInfoPane);
		topPane.getChildren().add(topPointPane);
		topPane.getChildren().add(topTierPane);
//		topPane.setPrefSize(160, 200);
		topPane.setMaxSize(160, 100);
		
		centerPane.setSpacing(10);
		centerPane.setPadding(new Insets(5));
		centerPane.setAlignment(Pos.TOP_CENTER);
		centerPane.getChildren().add(topPane);
		if (share.getUser().getId().equals("admin")) {
//			System.out.println("@@ Mypage menu - admin ??????");
			Label adminLabel = new Label();
			adminLabel.setText("- ????????? ?????? -");
			adminLabel.setPrefSize(160, 30);
			adminLabel.setAlignment(Pos.BOTTOM_CENTER);
			adminLabel.setFont(Font.font(15));
			
			centerPane.getChildren().add(adminLabel);
			centerPane.getChildren().add(modifyBookDBButton);
			centerPane.getChildren().add(outstandingBookButton);
			centerPane.getChildren().add(customerListButton);
//			rootPane.getChildren().add(modifyWebsiteButton);
		} else {
//			System.out.println("@@ Mypage menu - ???????????? ??????");
			Label userLabel = new Label();
			userLabel.setText("- ?????? ?????? -");
			userLabel.setPrefSize(160, 30);
			userLabel.setAlignment(Pos.BOTTOM_CENTER);
			userLabel.setFont(Font.font(15));
			
			centerPane.getChildren().add(userLabel);
			centerPane.getChildren().add(myBorrowStatButton);
//			rootPane.getChildren().add(myBorrowLogButton);
//			rootPane.getChildren().add(myInterBookButton);
			centerPane.getChildren().add(modifyMyInfoButton);
			centerPane.getChildren().add(withdrawButton);
		}
		
		rootPane.setTop(topPane);
		rootPane.setCenter(centerPane);
		
		return rootPane;
	}
	
}
