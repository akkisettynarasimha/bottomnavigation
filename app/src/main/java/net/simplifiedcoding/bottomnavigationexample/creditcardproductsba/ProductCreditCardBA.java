package net.simplifiedcoding.bottomnavigationexample.creditcardproductsba;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.simplifiedcoding.bottomnavigationexample.R;
import net.simplifiedcoding.bottomnavigationexample.SharedPreferenceManager;


public class ProductCreditCardBA extends AppCompatActivity {
    ImageView front, back,rotate;
    WebView webView;
    TextView cardName,viewDetails,approvalTime,annualFee,renewalFee;

    String cardname,imm,imgbb,appTime,anualFee,rewlFee,webvi;
    private Context context;
    SharedPreferenceManager sharedPrefMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_product_credit_card_b );

       // getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        Bundle b = getIntent().getExtras();

        if(b!=null){

           cardname=b.getString( "cardnaem" );
            imm = b.getString("imgfn" );
            imgbb = b.getString("imgback" );
            webvi=b.getString( "eligibility" );
            appTime=b.getString( "approval_time" );
            anualFee=b.getString( "annual_fee" );


        }
        //Toast.makeText( getBaseContext(), "Web: "+webvi, Toast.LENGTH_LONG ).show();

        cardName=findViewById( R.id.cardName );
        cardName.setText( cardname );
            front = findViewById( R.id.iciciFront );
            back = findViewById( R.id.iciciBack );
            approvalTime=findViewById( R.id.approval_Time );
            approvalTime.setText( appTime );
            annualFee=findViewById( R.id.annual_Fee );
            annualFee.setText( anualFee );
            renewalFee=findViewById( R.id.renewal_Fee );
            renewalFee.setText( rewlFee );
        webView=findViewById( R.id.webView );
             webView.loadUrl( webvi );

        if (getApplicationContext().equals("")) {
            Picasso.with(context)
                    .load(R.drawable.credit_card_icon)
                    .placeholder(R.drawable.credit_card_icon)
                    //    .resize(width, width)
                    .into(front);

        } else {
            Picasso.with(context)
                    .load(imm )
                    .placeholder(R.drawable.credit_card_icon)
                    //  .resize(width, width)
                    .into(front);
        }


      /*  Picasso.with(getApplicationContext())
                .load(IConstant.imageFront)
                .placeholder(R.drawable.credit_card_icon)
                //  .resize(width, width)
                .into(front);*/

        if (getApplicationContext().equals( "" )) {
            Picasso.with(context)
                    .load(R.drawable.credit_card_icon)
                    .placeholder(R.drawable.credit_card_icon)
                    //    .resize(width, width)
                    .into(back);

        } else {
            Picasso.with( getApplicationContext() )
                    .load(imgbb)
                    .placeholder( R.drawable.credit_card_icon )
                    //  .resize(width, width)
                    .into( back );
        }



        viewDetails=findViewById( R.id.viewDetails );
            viewDetails.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (webView.getVisibility() == View.GONE) {
                            webView.setVisibility(View.VISIBLE);
                            viewDetails.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                            viewDetails.setText( "Show less" );
                        } else {
                            webView.setVisibility(View.GONE);
                            viewDetails.setText( "View Details" );
                        }

            }
            });
    }
}
