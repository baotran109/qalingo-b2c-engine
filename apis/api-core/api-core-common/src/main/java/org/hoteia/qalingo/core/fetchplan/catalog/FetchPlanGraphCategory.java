package org.hoteia.qalingo.core.fetchplan.catalog;

import java.util.ArrayList;
import java.util.List;

import org.hoteia.qalingo.core.domain.CatalogCategoryVirtual_;
import org.hoteia.qalingo.core.fetchplan.FetchPlan;
import org.hoteia.qalingo.core.fetchplan.SpecificAlias;
import org.hoteia.qalingo.core.fetchplan.SpecificFetchMode;

public class FetchPlanGraphCategory {

    // MASTER
    
    public static FetchPlan defaultMasterCatalogCategoryFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultCatalogCategoryFetchModes();
        return new FetchPlan(fetchplans);
    }
    
    // VIRTUAL
    
    public static FetchPlan virtualCategoryWithoutProductsAndAssetsFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultVirtualCatalogCategoryFetchModes();
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategories.getName()));
        return new FetchPlan(fetchplans);
    }
    
    public static FetchPlan virtualCategoryWithProductsAndAssetsFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultVirtualCatalogCategoryFetchModes();
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategories.getName()));
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategoryProductSkuRels.getName()));
        fetchplans.add(new SpecificFetchMode("productSku", new SpecificAlias("catalogCategoryProductSkuRels.pk.productSku")));

        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.assets.getName()));

        return new FetchPlan(fetchplans);
    }
    
    public static FetchPlan defaultVirtualCatalogCategoryFetchPlan(){
        return new FetchPlan(defaultVirtualCatalogCategoryFetchModes());
    }
    
    public static FetchPlan menuCatalogCategoryFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultVirtualCatalogCategoryFetchModes();
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategories.getName()));
        return new FetchPlan(fetchplans);
    }
    
    public static FetchPlan footerCatalogCategoryFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultVirtualCatalogCategoryFetchModes();
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategories.getName()));
        return new FetchPlan(fetchplans);
    }
    
    protected static List<SpecificFetchMode> categoriesWithoutProductsAndAssetsFetchPlan(){
        List<SpecificFetchMode> fetchplans = defaultVirtualCatalogCategoryFetchModes();
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.catalogCategories.getName()));
        return fetchplans;
    }

    protected static List<SpecificFetchMode> defaultVirtualCatalogCategoryFetchModes(){
        List<SpecificFetchMode> fetchplans = defaultCatalogCategoryFetchModes();
        
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.categoryMaster.getName()));

        fetchplans.add(new SpecificFetchMode("parentCatalogCategoryMaster", new SpecificAlias("parentCatalogCategory.categoryMaster")));

        fetchplans.add(new SpecificFetchMode("catalogCategoryType", new SpecificAlias("categoryMaster.catalogCategoryType")));
        
        return fetchplans;
    }
    
    protected static List<SpecificFetchMode> defaultCatalogCategoryFetchModes(){
        List<SpecificFetchMode> fetchplans = new ArrayList<SpecificFetchMode>();
        
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.parentCatalogCategory.getName()));

        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.attributes.getName()));
        
        fetchplans.add(new SpecificFetchMode(CatalogCategoryVirtual_.assets.getName()));

        return fetchplans;
    }
    
}