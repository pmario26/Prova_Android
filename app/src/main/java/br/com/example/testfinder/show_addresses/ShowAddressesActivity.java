package br.com.example.testfinder.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import br.com.example.testfinder.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;

public class ShowAddressesActivity extends AppCompatActivity {

    //RecyclerView rvAddresses;
    @BindView(R.id.rv_addresses) RecyclerView rvAddresses;
    @BindView(R.id.tv_address) TextView tv_address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);


      //  rvAddresses = (RecyclerView) findViewById(R.id.rv_addresses);

        //captura a lista enviada pela MainActivity
        ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);
        ButterKnife.bind(this);
        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }

    @OnClick(R.id.address_item)
    public void tested(){
                Intent intentMapa = new Intent(Intent.ACTION_VIEW);
                intentMapa.setData(Uri.parse("geo:0,0?q=" + tv_address.getText().toString()));
                startActivity(intentMapa);

    }

}