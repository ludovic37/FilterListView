package com.crespeau.ludovic.filterlistview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private LinearLayout llContainer;
    private EditText etSearch;
    private ListView lvProducts;

    private ArrayList<Pays> mProductArrayList = new ArrayList<Pays>();
    private MyAdapter adapter1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();



        // Add Text Change Listener to EditText
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Call back the Adapter with current character to Filter
                adapter1.getFilter().filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void initialize() {
        etSearch = (EditText) findViewById(R.id.etSearch);
        lvProducts = (ListView)findViewById(R.id.lvProducts);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        initList();

        adapter1 = new MyAdapter(MainActivity.this, mProductArrayList);
        lvProducts.setAdapter(adapter1);
    }


//    // Adapter Class
//    public class MyAdapter extends BaseAdapter implements Filterable {
//
//        private ArrayList<Pays> mOriginalValues; // Original Values
//        private ArrayList<Pays> mDisplayedValues;    // Values to be displayed
//        LayoutInflater inflater;
//
//        public MyAdapter(Context context, ArrayList<Pays> mProductArrayList) {
//            this.mOriginalValues = mProductArrayList;
//            this.mDisplayedValues = mProductArrayList;
//            inflater = LayoutInflater.from(context);
//        }
//
//        @Override
//        public int getCount() {
//            return mDisplayedValues.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        private class ViewHolder {
//            LinearLayout llContainer;
//            TextView tvName,tvPrice;
//        }
//
//        @Override
//        public View getView(final int position, View convertView, ViewGroup parent) {
//
//            ViewHolder holder = null;
//
//            if (convertView == null) {
//
//                holder = new ViewHolder();
//                convertView = inflater.inflate(R.layout.row, null);
//                holder.llContainer = (LinearLayout)convertView.findViewById(R.id.llContainer);
//                holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
//                holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.tvName.setText(mDisplayedValues.get(position).name);
//
//            holder.llContainer.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View v) {
//
//                    Toast.makeText(MainActivity.this, mDisplayedValues.get(position).name, Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            return convertView;
//        }
//
//        @Override
//        public Filter getFilter() {
//            Filter filter = new Filter() {
//
//                @SuppressWarnings("unchecked")
//                @Override
//                protected void publishResults(CharSequence constraint,FilterResults results) {
//
//                    mDisplayedValues = (ArrayList<Pays>) results.values; // has the filtered values
//                    notifyDataSetChanged();  // notifies the data with new filtered values
//                }
//
//                @Override
//                protected Filter.FilterResults performFiltering(CharSequence constraint) {
//                    FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
//                    ArrayList<Pays> FilteredArrList = new ArrayList<Pays>();
//
//                    if (mOriginalValues == null) {
//                        mOriginalValues = new ArrayList<Pays>(mDisplayedValues); // saves the original data in mOriginalValues
//                    }
//
//                    /********
//                     *
//                     *  If constraint(CharSequence that is received) is null returns the mOriginalValues(Original) values
//                     *  else does the Filtering and returns FilteredArrList(Filtered)
//                     *
//                     ********/
//                    if (constraint == null || constraint.length() == 0) {
//
//                        // set the Original result to return
//                        results.count = mOriginalValues.size();
//                        results.values = mOriginalValues;
//                    } else {
//                        constraint = constraint.toString().toLowerCase();
//                        for (int i = 0; i < mOriginalValues.size(); i++) {
//                            String data = mOriginalValues.get(i).name;
//                            if (data.toLowerCase().contains(constraint.toString())) {
//                                FilteredArrList.add(new Pays(mOriginalValues.get(i).name));
//                            }
//                        }
//                        // set the Filtered result to return
//                        results.count = FilteredArrList.size();
//                        results.values = FilteredArrList;
//                    }
//                    return results;
//                }
//            };
//            return filter;
//        }
//    }


    public void initList(){
        mProductArrayList.add(new Pays("Afghanistan"));
        mProductArrayList.add(new Pays("Albanie"));
        mProductArrayList.add(new Pays("Antarctique"));
        mProductArrayList.add(new Pays("Algérie"));
        mProductArrayList.add(new Pays("Samoa Américaines"));
        mProductArrayList.add(new Pays("Andorre"));
        mProductArrayList.add(new Pays("Angola"));
        mProductArrayList.add(new Pays("Antigua-et-Barbuda"));
        mProductArrayList.add(new Pays("Azerbaïdjan"));
        mProductArrayList.add(new Pays("Argentine"));
        mProductArrayList.add(new Pays("Australie"));
        mProductArrayList.add(new Pays("Autriche"));
        mProductArrayList.add(new Pays("Bahamas"));
        mProductArrayList.add(new Pays("Bahreïn"));
        mProductArrayList.add(new Pays("Bangladesh"));
        mProductArrayList.add(new Pays("Arménie"));
        mProductArrayList.add(new Pays("Barbade"));
        mProductArrayList.add(new Pays("Belgique"));
        mProductArrayList.add(new Pays("Bermudes"));
        mProductArrayList.add(new Pays("Bhoutan"));
        mProductArrayList.add(new Pays("Bolivie"));
        mProductArrayList.add(new Pays("Bosnie-Herzégovine"));
        mProductArrayList.add(new Pays("Botswana"));
        mProductArrayList.add(new Pays("Île Bouvet"));
        mProductArrayList.add(new Pays("Brésil"));
        mProductArrayList.add(new Pays("Belize"));
        mProductArrayList.add(new Pays("Territoire Britannique de l'Océan Indien"));
        mProductArrayList.add(new Pays("Îles Salomon"));
        mProductArrayList.add(new Pays("Îles Vierges Britanniques"));
        mProductArrayList.add(new Pays("Brunéi Darussalam"));
        mProductArrayList.add(new Pays("Bulgarie"));
        mProductArrayList.add(new Pays("Myanmar"));
        mProductArrayList.add(new Pays("Burundi"));
        mProductArrayList.add(new Pays("Bélarus"));
        mProductArrayList.add(new Pays("Cambodge"));
        mProductArrayList.add(new Pays("Cameroun"));
        mProductArrayList.add(new Pays("Canada"));
        mProductArrayList.add(new Pays("Cap-vert"));
        mProductArrayList.add(new Pays("Îles Caïmanes"));
        mProductArrayList.add(new Pays("République Centrafricaine"));
        mProductArrayList.add(new Pays("Sri Lanka"));
        mProductArrayList.add(new Pays("Tchad"));
        mProductArrayList.add(new Pays("Chili"));
        mProductArrayList.add(new Pays("Chine"));
        mProductArrayList.add(new Pays("Taïwan"));
        mProductArrayList.add(new Pays("Île Christmas"));
        mProductArrayList.add(new Pays("Îles Cocos (Keeling)"));
        mProductArrayList.add(new Pays("Colombie"));
        mProductArrayList.add(new Pays("Comores"));
        mProductArrayList.add(new Pays("Mayotte"));
        mProductArrayList.add(new Pays("République du Congo"));
        mProductArrayList.add(new Pays("République Démocratique du Congo"));
        mProductArrayList.add(new Pays("Îles Cook"));
        mProductArrayList.add(new Pays("Costa Rica"));
        mProductArrayList.add(new Pays("Croatie"));
        mProductArrayList.add(new Pays("Cuba"));
        mProductArrayList.add(new Pays("Chypre"));
        mProductArrayList.add(new Pays("République Tchèque"));
        mProductArrayList.add(new Pays("Bénin"));
        mProductArrayList.add(new Pays("Danemark"));
        mProductArrayList.add(new Pays("Dominique"));
        mProductArrayList.add(new Pays("République Dominicaine"));
        mProductArrayList.add(new Pays("Équateur"));
        mProductArrayList.add(new Pays("El Salvador"));
        mProductArrayList.add(new Pays("Guinée Équatoriale"));
        mProductArrayList.add(new Pays("Éthiopie"));
        mProductArrayList.add(new Pays("Érythrée"));
        mProductArrayList.add(new Pays("Estonie"));
        mProductArrayList.add(new Pays("Îles Féroé"));
        mProductArrayList.add(new Pays("Îles (malvinas) Falkland"));
        mProductArrayList.add(new Pays("Géorgie du Sud et les Îles Sandwich du Sud"));
        mProductArrayList.add(new Pays("Fidji"));
        mProductArrayList.add(new Pays("Finlande"));
        mProductArrayList.add(new Pays("Îles Åland"));
        mProductArrayList.add(new Pays("France"));
        mProductArrayList.add(new Pays("Guyane Française"));
        mProductArrayList.add(new Pays("Polynésie Française"));
        mProductArrayList.add(new Pays("Terres Australes Françaises"));
        mProductArrayList.add(new Pays("Djibouti"));
        mProductArrayList.add(new Pays("Gabon"));
        mProductArrayList.add(new Pays("Géorgie"));
        mProductArrayList.add(new Pays("Gambie"));
        mProductArrayList.add(new Pays("Territoire Palestinien Occupé"));
        mProductArrayList.add(new Pays("Allemagne"));
        mProductArrayList.add(new Pays("Ghana"));
        mProductArrayList.add(new Pays("Gibraltar"));
        mProductArrayList.add(new Pays("Kiribati"));
        mProductArrayList.add(new Pays("Grèce"));
        mProductArrayList.add(new Pays("Groenland"));
        mProductArrayList.add(new Pays("Grenade"));
        mProductArrayList.add(new Pays("Guadeloupe"));
        mProductArrayList.add(new Pays("Guam"));
        mProductArrayList.add(new Pays("Guatemala"));
        mProductArrayList.add(new Pays("Guinée"));
        mProductArrayList.add(new Pays("Guyana"));
        mProductArrayList.add(new Pays("Haïti"));
        mProductArrayList.add(new Pays("Îles Heard et Mcdonald"));
        mProductArrayList.add(new Pays("Saint-Siège (état de la Cité du Vatican)"));
        mProductArrayList.add(new Pays("Honduras"));
        mProductArrayList.add(new Pays("Hong-Kong"));
        mProductArrayList.add(new Pays("Hongrie"));
        mProductArrayList.add(new Pays("Islande"));
        mProductArrayList.add(new Pays("Inde"));
        mProductArrayList.add(new Pays("Indonésie"));
        mProductArrayList.add(new Pays("République Islamique d'Iran"));
        mProductArrayList.add(new Pays("Iraq"));
        mProductArrayList.add(new Pays("Irlande"));
        mProductArrayList.add(new Pays("Israël"));
        mProductArrayList.add(new Pays("Italie"));
        mProductArrayList.add(new Pays("Côte d'Ivoire"));
        mProductArrayList.add(new Pays("Jamaïque"));
        mProductArrayList.add(new Pays("Japon"));
        mProductArrayList.add(new Pays("Kazakhstan"));
        mProductArrayList.add(new Pays("Jordanie"));
        mProductArrayList.add(new Pays("Kenya"));
        mProductArrayList.add(new Pays("République Populaire Démocratique de Corée"));
        mProductArrayList.add(new Pays("République de Corée"));
        mProductArrayList.add(new Pays("Koweït"));
        mProductArrayList.add(new Pays("Kirghizistan"));
        mProductArrayList.add(new Pays("République Démocratique Populaire Lao"));
        mProductArrayList.add(new Pays("Liban"));
        mProductArrayList.add(new Pays("Lesotho"));
        mProductArrayList.add(new Pays("Lettonie"));
        mProductArrayList.add(new Pays("Libéria"));
        mProductArrayList.add(new Pays("Jamahiriya Arabe Libyenne"));
        mProductArrayList.add(new Pays("Liechtenstein"));
        mProductArrayList.add(new Pays("Lituanie"));
        mProductArrayList.add(new Pays("Luxembourg"));
        mProductArrayList.add(new Pays("Macao"));
        mProductArrayList.add(new Pays("Madagascar"));
        mProductArrayList.add(new Pays("Malawi"));
        mProductArrayList.add(new Pays("Malaisie"));
        mProductArrayList.add(new Pays("Maldives"));
        mProductArrayList.add(new Pays("Mali"));
        mProductArrayList.add(new Pays("Malte"));
        mProductArrayList.add(new Pays("Martinique"));
        mProductArrayList.add(new Pays("Mauritanie"));
        mProductArrayList.add(new Pays("Maurice"));
        mProductArrayList.add(new Pays("Mexique"));
        mProductArrayList.add(new Pays("Monaco"));
        mProductArrayList.add(new Pays("Mongolie"));
        mProductArrayList.add(new Pays("République de Moldova"));
        mProductArrayList.add(new Pays("Montserrat"));
        mProductArrayList.add(new Pays("Maroc"));
        mProductArrayList.add(new Pays("Mozambique"));
        mProductArrayList.add(new Pays("Oman"));
        mProductArrayList.add(new Pays("Namibie"));
        mProductArrayList.add(new Pays("Nauru"));
        mProductArrayList.add(new Pays("Népal"));
        mProductArrayList.add(new Pays("Pays-Bas"));
        mProductArrayList.add(new Pays("Antilles Néerlandaises"));
        mProductArrayList.add(new Pays("Aruba"));
        mProductArrayList.add(new Pays("Nouvelle-Calédonie"));
        mProductArrayList.add(new Pays("Vanuatu"));
        mProductArrayList.add(new Pays("Nouvelle-Zélande"));
        mProductArrayList.add(new Pays("Nicaragua"));
        mProductArrayList.add(new Pays("Niger"));
        mProductArrayList.add(new Pays("Nigéria"));
        mProductArrayList.add(new Pays("Niué"));
        mProductArrayList.add(new Pays("Île Norfolk"));
        mProductArrayList.add(new Pays("Norvège"));
        mProductArrayList.add(new Pays("Îles Mariannes du Nord"));
        mProductArrayList.add(new Pays("Îles Mineures Éloignées des États-Unis"));
        mProductArrayList.add(new Pays("États Fédérés de Micronésie"));
        mProductArrayList.add(new Pays("Îles Marshall"));
        mProductArrayList.add(new Pays("Palaos"));
        mProductArrayList.add(new Pays("Pakistan"));
        mProductArrayList.add(new Pays("Panama"));
        mProductArrayList.add(new Pays("Papouasie-Nouvelle-Guinée"));
        mProductArrayList.add(new Pays("Paraguay"));
        mProductArrayList.add(new Pays("Pérou"));
        mProductArrayList.add(new Pays("Philippines"));
        mProductArrayList.add(new Pays("Pitcairn"));
        mProductArrayList.add(new Pays("Pologne"));
        mProductArrayList.add(new Pays("Portugal"));
        mProductArrayList.add(new Pays("Guinée-Bissau"));
        mProductArrayList.add(new Pays("Timor-Leste"));
        mProductArrayList.add(new Pays("Porto Rico"));
        mProductArrayList.add(new Pays("Qatar"));
        mProductArrayList.add(new Pays("Réunion"));
        mProductArrayList.add(new Pays("Roumanie"));
        mProductArrayList.add(new Pays("Fédération de Russie"));
        mProductArrayList.add(new Pays("Rwanda"));
        mProductArrayList.add(new Pays("Sainte-Hélène"));
        mProductArrayList.add(new Pays("Saint-Kitts-et-Nevis"));
        mProductArrayList.add(new Pays("Anguilla"));
        mProductArrayList.add(new Pays("Sainte-Lucie"));
        mProductArrayList.add(new Pays("Saint-Pierre-et-Miquelon"));
        mProductArrayList.add(new Pays("Saint-Vincent-et-les Grenadines"));
        mProductArrayList.add(new Pays("Saint-Marin"));
        mProductArrayList.add(new Pays("Sao Tomé-et-Principe"));
        mProductArrayList.add(new Pays("Arabie Saoudite"));
        mProductArrayList.add(new Pays("Sénégal"));
        mProductArrayList.add(new Pays("Seychelles"));
        mProductArrayList.add(new Pays("Sierra Leone"));
        mProductArrayList.add(new Pays("Singapour"));
        mProductArrayList.add(new Pays("Slovaquie"));
        mProductArrayList.add(new Pays("Viet Nam"));
        mProductArrayList.add(new Pays("Slovénie"));
        mProductArrayList.add(new Pays("Somalie"));
        mProductArrayList.add(new Pays("Afrique du Sud"));
        mProductArrayList.add(new Pays("Zimbabwe"));
        mProductArrayList.add(new Pays("Espagne"));
        mProductArrayList.add(new Pays("Sahara Occidental"));
        mProductArrayList.add(new Pays("Soudan"));
        mProductArrayList.add(new Pays("Suriname"));
        mProductArrayList.add(new Pays("Svalbard etÎle Jan Mayen"));
        mProductArrayList.add(new Pays("Swaziland"));
        mProductArrayList.add(new Pays("Suède"));
        mProductArrayList.add(new Pays("Suisse"));
        mProductArrayList.add(new Pays("République Arabe Syrienne"));
        mProductArrayList.add(new Pays("Tadjikistan"));
        mProductArrayList.add(new Pays("Thaïlande"));
        mProductArrayList.add(new Pays("Togo"));
        mProductArrayList.add(new Pays("Tokelau"));
        mProductArrayList.add(new Pays("Tonga"));
        mProductArrayList.add(new Pays("Trinité-et-Tobago"));
        mProductArrayList.add(new Pays("Émirats Arabes Unis"));
        mProductArrayList.add(new Pays("Tunisie"));
        mProductArrayList.add(new Pays("Turquie"));
        mProductArrayList.add(new Pays("Turkménistan"));
        mProductArrayList.add(new Pays("Îles Turks et Caïques"));
        mProductArrayList.add(new Pays("Tuvalu"));
        mProductArrayList.add(new Pays("Ouganda"));
        mProductArrayList.add(new Pays("Ukraine"));
        mProductArrayList.add(new Pays("L'ex-République Yougoslave de Macédoine"));
        mProductArrayList.add(new Pays("Égypte"));
        mProductArrayList.add(new Pays("Royaume-Uni"));
        mProductArrayList.add(new Pays("Île de Man"));
        mProductArrayList.add(new Pays("République-Unie de Tanzanie"));
        mProductArrayList.add(new Pays("États-Unis"));
        mProductArrayList.add(new Pays("Îles Vierges des États-Unis"));
        mProductArrayList.add(new Pays("Burkina Faso"));
        mProductArrayList.add(new Pays("Uruguay"));
        mProductArrayList.add(new Pays("Ouzbékistan"));
        mProductArrayList.add(new Pays("Venezuela"));
        mProductArrayList.add(new Pays("Wallis et Futuna"));
        mProductArrayList.add(new Pays("Samoa"));
        mProductArrayList.add(new Pays("Yémen"));
        mProductArrayList.add(new Pays("Serbie-et-Monténégro"));
        mProductArrayList.add(new Pays("Zambie"));
    }
}
